/*  Copyright (C) 2003-2015 JabRef contributors.
    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along
    with this program; if not, write to the Free Software Foundation, Inc.,
    51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */
package net.sf.jabref.logic.util;

import net.sf.jabref.gui.desktop.os.*;

/***
 * Operating system (OS) detection
 */
public class OS {
    // https://commons.apache.org/proper/commons-lang/javadocs/api-2.6/org/apache/commons/lang/SystemUtils.html
    private static final String OS_NAME = System.getProperty("os.name", "unknown").toLowerCase();

    public static final boolean LINUX = OS_NAME.startsWith("linux");
    public static final boolean WINDOWS = OS_NAME.startsWith("win");
    public static final boolean OS_X = OS_NAME.startsWith("mac");

    public static final NativeDesktop ND_LINUX = new Linux();
    public static final NativeDesktop ND_WINDOWS = new Windows();
    public static final NativeDesktop ND_MAC = new OSX();
    public static final NativeDesktop ND_DEFAULT = new DefaultDesktop();

    public static NativeDesktop getNativeDesktop() {
        if(WINDOWS) {
            return ND_WINDOWS;
        } else if(OS_X) {
            return ND_MAC;
        } else if(LINUX) {
            return ND_LINUX;
        }
        return ND_DEFAULT;
    }

}
