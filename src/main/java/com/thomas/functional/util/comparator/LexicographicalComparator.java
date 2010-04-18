/**
 * $Id$
 *
 * Copyright (c) 2007 Thomas Beckmann 
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
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 16.01.2007
 */
public class LexicographicalComparator<T>
        implements Comparator<Collection<? extends T>>, Serializable {

    private static final long serialVersionUID = -9025417482287283958L;

    private final Comparator<? super T> base;

    public LexicographicalComparator(Comparator<? super T> comp) {

        if (comp == null) throw new NullPointerException();

        this.base = comp;
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
    public int compare(Collection<? extends T> o1, Collection<? extends T> o2) {

        final Iterator<? extends T> i1 = o1.iterator();
        final Iterator<? extends T> i2 = o2.iterator();

        while (i1.hasNext()) {

            if (!i2.hasNext()) return 1;

            final int c = this.base.compare(i1.next(), i2.next());

            if (c != 0) return c;
        }

        return i2.hasNext() ? -1 : 0;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        return "LexicographicalComparator[base=" + this.base + "]";
    }

}
