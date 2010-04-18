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
package com.freiheit.jafp.util.comparator;

import java.io.Serializable;
import java.util.Comparator;

import com.freiheit.jafp.function.Function2;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 10.06.2007
 */
public class LessComparator<T> implements Comparator<T>, Serializable {

    private static final long serialVersionUID = -448027002796063743L;

    private final Function2<? extends Boolean, ? super T, ? super T> less;

    public LessComparator(
            Function2<? extends Boolean, ? super T, ? super T> less) {

        if (less == null) throw new NullPointerException();

        this.less = less;
    }

    /**
     * TODO Method documentation
     * 
     * @param o1
     * @param o2
     * @return
     * @see java.util.Comparator#compare(T, T)
     * @author Thomas
     * @since 10.06.2007
     */
    public int compare(T o1, T o2) {

        if (this.less.call(o1, o2)) return -1;
        if (this.less.call(o2, o1)) return 1;

        return 0;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        return "LessComparator[less=" + this.less + "]";
    }

}
