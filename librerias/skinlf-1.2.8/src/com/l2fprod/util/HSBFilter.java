/** ===================================================================
 *
 * Skin Look And Feel 1.2.8 License.
 *
 * Copyright (c) 2000-2004 L2FProd.com.  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:
 *       "This product includes software developed by L2FProd.com
 *        (http://www.L2FProd.com/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "Skin Look And Feel", "@PROJECT.SHORTNAME@" and "L2FProd.com" must not
 *    be used to endorse or promote products derived from this software
 *    without prior written permission. For written permission, please
 *    contact info@L2FProd.com.
 *
 * 5. Products derived from this software may not be called "@PROJECT.SHORTNAME@"
 *    nor may "@PROJECT.SHORTNAME@" appear in their names without prior written
 *    permission of L2FProd.com.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL L2FPROD.COM OR ITS CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR
 * BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * ====================================================================
 */
package com.l2fprod.util;

import java.awt.Color;
import java.awt.image.RGBImageFilter;

/**
 * HSBFilter. <br>
 *  
 */
public class HSBFilter extends RGBImageFilter {

  /*
   * A private variable used to hold hue/saturation/brightness values returned
   * from the static conversion methods in Color.
   */
  private float hsbvals[] = new float[3];

  /**
   * the Hue of the indicated new foreground color.
   */
  float fgHue;

  /**
   * the Saturation of the indicated new foreground color.
   */
  float fgSaturation;

  /**
   * the Brightness of the indicated new foreground color.
   */
  float fgBrightness;

  /**
   * Construct a HueFilter object which performs color modifications to warp
   * existing image colors to have a new primary hue.
   */
  public HSBFilter(Color fg) {
    Color.RGBtoHSB(fg.getRed(), fg.getGreen(), fg.getBlue(), hsbvals);
    fgHue = hsbvals[0];
    fgSaturation = hsbvals[1];
    fgBrightness = hsbvals[2];
    canFilterIndexColorModel = true;
  }

  /**
   * Filter an individual pixel in the image by modifying its hue, saturation,
   * and brightness components to be similar to the indicated new foreground
   * color.
   */
  public int filterRGB(int x, int y, int rgb) {
    int alpha = (rgb >> 24) & 0xff;
    int red = (rgb >> 16) & 0xff;
    int green = (rgb >> 8) & 0xff;
    int blue = (rgb) & 0xff;
    Color.RGBtoHSB(red, green, blue, hsbvals);
    float newHue = fgHue;
    float newSaturation = hsbvals[1] * fgSaturation;
    float newBrightness =
      hsbvals[2] * (hsbvals[1] * fgBrightness + (1 - hsbvals[1]));
    rgb = Color.HSBtoRGB(newHue, newSaturation, newBrightness);
    return (rgb & 0x00ffffff) | (alpha << 24);
  }

}
