/**
 * $Id$
 *
 * Copyright (c) 2009 Thomas Beckmann 
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
package com.freiheit.jafp.util.comparator;

import java.io.Serializable;
import java.util.Comparator;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 11.04.2009
 */
public class NullComparator<T> implements Comparator<T>, Serializable {

    private static final long serialVersionUID = -9025417482287283958L;

    private final Comparator<? super T> base;
    private final int diffNull;

    public NullComparator(Comparator<? super T> comp, boolean nullIsLess) {

        if (comp == null) throw new NullPointerException();

        this.base = comp;
        this.diffNull = nullIsLess ? -1 : 1;
    }

    public NullComparator(Comparator<? super T> comp) {

        this(comp, true);
    }

    /**
     * TODO Method documentation
     * 
     * @param o1
     * @param o2
     * @return
     * @see java.util.Comparator#compare(T, T)
     * @author Thomas
     * @since 05.12.2005
     */
    public int compare(T o1, T o2) {

        return o1 == null
            ? (o2 == null ? 1 : this.diffNull)
            : (o2 == null ? -this.diffNull : this.base.compare(o1, o2));
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        return "NullComparator[base=" + this.base + "]";
    }

}
