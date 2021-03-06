/* ====================================================================
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
 * 4. The names "Skin Look And Feel", "SkinLF" and "L2FProd.com" must not
 *    be used to endorse or promote products derived from this software
 *    without prior written permission. For written permission, please
 *    contact info@L2FProd.com.
 *
 * 5. Products derived from this software may not be called "SkinLF"
 *    nor may "SkinLF" appear in their names without prior written
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
package com.l2fprod.gui.plaf.skin;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.Icon;
import javax.swing.plaf.basic.*;

/**
 * Created on 05/04/2000 by Frederic Lavigne, fred@L2FProd.com
 *
 * @author    $Author: l2fprod $
 * @created   27 avril 2002
 * @version   $Revision: 1.1 $, $Date: 2003/08/01 19:47:23 $
 */
public class SkinComboBoxRenderer extends BasicComboBoxRenderer {

  /**
   * Constructor for the SkinComboBoxRenderer object
   */
  public SkinComboBoxRenderer() {
    super();
    setOpaque(false);
    setBorder(null);
  }

  /**
   * Gets the ListCellRendererComponent attribute of the SkinComboBoxRenderer
   * object
   *
   * @param list          Description of Parameter
   * @param value         Description of Parameter
   * @param index         Description of Parameter
   * @param isSelected    Description of Parameter
   * @param cellHasFocus  Description of Parameter
   * @return              The ListCellRendererComponent value
   */
  public Component getListCellRendererComponent(
      JList list,
      Object value,
      int index,
      boolean isSelected,
      boolean cellHasFocus) {

    // if index == -1 then we are painting the selected value (but not a value in the list)
    if (index == -1) {
      setOpaque(false);
    }
    else {
      setOpaque(true);
    }

    if ((index != -1) && isSelected) {
      setBackground(list.getSelectionBackground());
      setForeground(list.getSelectionForeground());
    }
    else {
      setBackground(list.getBackground());
      setForeground(list.getForeground());
    }

    setFont(list.getFont());

    if (value instanceof Icon) {
      setIcon((Icon) value);
    }
    else {
      setText((value == null) ? "" : value.toString());
    }
    return this;
  }

}
