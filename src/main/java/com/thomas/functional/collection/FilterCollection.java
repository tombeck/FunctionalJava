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
package com.thomas.functional.collection;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

import com.thomas.functional.function.Function1;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 29.04.2007
 */
final class FilterCollection<E> extends AbstractCollection<E> {

    final Function1<? extends Boolean, ? super E> pred;
    final Collection<? extends E> delegee;

    public FilterCollection(
            Function1<? extends Boolean, ? super E> pred,
            Collection<? extends E> base) {

        if (pred == null) throw new NullPointerException();
        if (base == null) throw new NullPointerException();

        this.pred = pred;
        this.delegee = base;
    }

    class _Iterator implements Iterator<E> {

        private final Iterator<? extends E> iter = FilterCollection.this.delegee.iterator();
        
        private boolean hasNext = false;
        private E next;
        
        public boolean hasNext() {

            while (!this.hasNext && this.iter.hasNext()) {
                this.next = this.iter.next();
                this.hasNext = FilterCollection.this.pred.call(this.next);
            }

            return this.hasNext;
        }

        public E next() {

            while (!this.hasNext) {
                this.next = this.iter.next();
                this.hasNext = FilterCollection.this.pred.call(this.next);
            }
            this.hasNext = false;
            
            return this.next;
        }

        public void remove() {

            throw new UnsupportedOperationException();
        }
        
    }
    
    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.AbstractCollection#iterator()
     * @author Thomas
     * @since 29.04.2007
     */
    @Override
    public Iterator<E> iterator() {

        return new _Iterator();
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.AbstractCollection#size()
     * @author Thomas
     * @since 29.04.2007
     */
    @Override
    public int size() {

        int ret = 0;

        for (E element : this.delegee) {
            if (this.pred.call(element)) {
                ++ret;
            }
        }

        return ret;
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.AbstractCollection#isEmpty()
     * @author Thomas
     * @since 29.04.2007
     */
    @Override
    public boolean isEmpty() {

        for (E element : this.delegee) {
            if (this.pred.call(element)) {
                
                return false;
            }
        }
        
        return true;
    }

}
