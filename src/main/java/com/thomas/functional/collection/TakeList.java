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
package com.thomas.functional.collection;

import static java.lang.Math.min;

import java.util.AbstractList;
import java.util.List;

/**
 * TODO Type documentation
 *
 * @author Thomas
 * @since 19.07.2009
 */
final class TakeList<E> extends AbstractList<E> {

    final List<E> base;
    final int maxSize;

    public TakeList(List<E> base, int size) {

        if (base == null) throw new NullPointerException();
        if (size < 0) throw new IllegalArgumentException();
        
        this.base = base;
        this.maxSize = size;
    }

    /**
     * TODO Method documentation
     * 
     * @param index
     * @return
     * @see java.util.AbstractList#get(int)
     * @author Thomas
     * @since 19.07.2009
     */
    @Override
    public E get(int index) {

        if (index < this.maxSize) return this.base.get(index);
        
        throw new IndexOutOfBoundsException();
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.AbstractCollection#size()
     * @author Thomas
     * @since 19.07.2009
     */
    @Override
    public int size() {

        return min(this.maxSize, this.base.size());
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.Collection#isEmpty()
     * @author Thomas
     * @since 19.07.2009
     */
    @Override
    public boolean isEmpty() {

        return this.maxSize == 0 || this.base.isEmpty();
    }

}
