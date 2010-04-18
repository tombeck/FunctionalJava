/**
 * $Id$
 *
 * Copyright (c) 2005 Thomas Beckmann 
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.thomas.functional.util.comparator;

import java.io.Serializable;
import java.util.Comparator;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 17.10.2005
 */
public final class ComparableComparator<T extends Comparable<? super T>>
        implements Comparator<T>, Serializable {

    private static final long serialVersionUID = 6871360560206126312L;

    /**
     * TODO Method documentation
     * 
     * @param o1
     * @param o2
     * @return
     * @see java.util.Comparator#compare(T, T)
     * @author Thomas
     * @since 17.10.2005
     */
    public int compare(T o1, T o2) {

        return o1.compareTo(o2);
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        return "ComparableComparator";
    }

}
