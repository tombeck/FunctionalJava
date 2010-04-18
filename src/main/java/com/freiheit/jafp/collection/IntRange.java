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
package com.freiheit.jafp.collection;

import java.util.AbstractList;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 12.12.2009
 */
final class IntRange extends AbstractList<Integer> {

    private final int first;
    private final int last;
    private final int step;
    
    public IntRange(int first, int last, int step) {

        if (first >= last) throw new IllegalArgumentException();
        if (step == 0) throw new IllegalArgumentException();
        
        this.first = first;
        this.last = last;
        this.step = step;
    }

    /**
     * TODO Method documentation
     * 
     * @param index
     * @return
     * @see java.util.AbstractList#get(int)
     * @author Thomas
     * @since 12.12.2009
     */
    @Override
    public Integer get(int index) {

        int ret = this.first + index * this.step;

        if (ret >= this.last) throw new IndexOutOfBoundsException();
        
        return ret;
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.AbstractCollection#size()
     * @author Thomas
     * @since 12.12.2009
     */
    @Override
    public int size() {

        return (this.last - this.first) + (this.step - 1) / this.step;
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.AbstractCollection#isEmpty()
     * @author Thomas
     * @since 30.12.2009
     */
    @Override
    public boolean isEmpty() {
    
        return false;
    }
    
}
