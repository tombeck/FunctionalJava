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

import static com.thomas.functional.collection.util.iterator.Iterators.lookAheadListIterator;
import static java.lang.Math.max;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.thomas.functional.collection.util.iterator.LookAheadListIterator;
import com.thomas.functional.function.Function2;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 04.10.2009
 */
final class AdjacentPairList<E, T> extends AbstractList<E> {

    final List<T> delegee;
    final Function2<? extends E, ? super T, ? super T> func;

    /**
     * TODO Ctor documentation
     * 
     * @param base
     * @author Thomas
     * @since 16.10.2006
     */
    public AdjacentPairList(
            Function2<? extends E, ? super T, ? super T> func,
            List<T> base) {

        if (base == null) throw new NullPointerException();
        if (func == null) throw new NullPointerException();

        this.delegee = base;
        this.func = func;
    }
    
    class _ListIterator implements ListIterator<E> {

        private final LookAheadListIterator<T> iter;

        private boolean before = true;
        
        public _ListIterator() {
            
            this.iter = lookAheadListIterator(AdjacentPairList.this.delegee.listIterator());
        }
        
        public _ListIterator(int index) {
            
            this.iter = lookAheadListIterator(AdjacentPairList.this.delegee.listIterator(index));
        }
        
        @Override
        public void add(@SuppressWarnings("unused") E e) {

            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {

            if (this.before) {
                if (!this.iter.hasNext()) return false;
                this.iter.next();
                this.before = false;
                
                return this.iter.hasNext();
            }
            
            return this.iter.hasNext() && this.iter.hasPrevious();
        }

        @Override
        public boolean hasPrevious() {

            if (!this.before) {
                if (!this.iter.hasPrevious()) return false;
                this.iter.previous();
                this.before = true;
                
                return this.iter.hasPrevious();
            }
            
            return this.iter.hasNext() && this.iter.hasPrevious();
        }

        @Override
        public E next() {

            if (this.before) {
                this.iter.next();
                this.before = false;
            }

            final E ret = AdjacentPairList.this.func.call(
                    this.iter.peekPrevious(),
                    this.iter.peekNext());
            
            this.before = true;
            
            return ret;
        }

        @Override
        public int nextIndex() {

            return this.before ? this.iter.nextIndex() :this.iter.previousIndex();
        }

        @Override
        public E previous() {

            if (!this.before) {
                this.iter.previous();
                this.before = true;
            }

            final E ret = AdjacentPairList.this.func.call(
                    this.iter.peekPrevious(),
                    this.iter.peekNext());
            
            this.before = false;
            
            return ret;
        }

        @Override
        public int previousIndex() {

            return nextIndex() - 1;
        }

        @Override
        public void remove() {

            throw new UnsupportedOperationException();
        }

        @Override
        public void set(@SuppressWarnings("unused") E e) {

            throw new UnsupportedOperationException();
        }
        
    }
    
    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.AbstractList#listIterator()
     * @author Thomas
     * @since 10.10.2009
     */
    @Override
    public ListIterator<E> listIterator() {
    
        return new _ListIterator();
    }
    
    /**
     * TODO Method documentation
     * 
     * @param index
     * @return
     * @see java.util.AbstractList#listIterator(int)
     * @author Thomas
     * @since 10.10.2009
     */
    @Override
    public ListIterator<E> listIterator(int index) {
    
        return new _ListIterator(index);
    }
    
    class _Iterator implements Iterator<E> {
        
        private final Iterator<T> iter = AdjacentPairList.this.delegee.iterator();
        
        private T next = this.iter.hasNext() ? this.iter.next() : null;
        
        public boolean hasNext() {
            
            return this.iter.hasNext();
        }
        
        public E next() {
            
            final T prev = this.next;
            
            this.next = this.iter.next();
            
            return AdjacentPairList.this.func.call(prev, this.next);
        }
        
        public void remove() {
            
            throw new UnsupportedOperationException();
        }
        
    }
    
    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.AbstractList#iterator()
     * @author Thomas
     * @since 10.10.2009
     */
    @Override
    public Iterator<E> iterator() {
    
        return new _Iterator();
    }
    
    /**
     * TODO Method documentation
     * 
     * @param index
     * @return
     * @see java.util.AbstractList#get(int)
     * @author Thomas
     * @since 04.10.2009
     */
    @Override
    public E get(int index) {

        return this.func.call(this.delegee.get(index), this.delegee.get(index + 1));
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.AbstractCollection#size()
     * @author Thomas
     * @since 04.10.2009
     */
    @Override
    public int size() {

        return max(0, this.delegee.size() - 1);
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.Collection#isEmpty()
     * @author Thomas
     * @since 21.05.2006
     */
    @Override
    public boolean isEmpty() {

        return this.delegee.size() <= 1;
    }

}
