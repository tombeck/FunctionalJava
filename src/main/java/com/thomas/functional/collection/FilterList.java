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

import static com.thomas.functional.collection.util.iterator.Iterators.forward;
import static com.thomas.functional.collection.util.iterator.Iterators.lookAheadListIterator;
import static com.thomas.functional.collection.util.iterator.Iterators.unmodifiableListIterator;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import com.thomas.functional.collection.util.iterator.LookAheadListIterator;
import com.thomas.functional.function.Function1;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 03.10.2009
 */
final class FilterList<E> extends AbstractList<E> {

    final Function1<? extends Boolean, ? super E> pred;
    final List<? extends E> delegee;

    public FilterList(
            Function1<? extends Boolean, ? super E> pred,
            List<? extends E> base) {

        if (pred == null) throw new NullPointerException();
        if (base == null) throw new NullPointerException();

        this.pred = pred;
        this.delegee = base;
    }

    /**
     * TODO Method documentation
     * 
     * @param index
     * @return
     * @see java.util.AbstractList#get(int)
     * @author Thomas
     * @since 03.10.2009
     */
    @Override
    public E get(int index) {

        if (index < 0) throw new IndexOutOfBoundsException();
        
        for (E element : this.delegee) {
            if (this.pred.call(element)) {
                if (index == 0) return element;
                --index;
            }
        }

        throw new IndexOutOfBoundsException();
    }

    class _ListIterator implements ListIterator<E> {

        private final LookAheadListIterator<E> iter = lookAheadListIterator(unmodifiableListIterator(FilterList.this.delegee.listIterator()));
        
        private boolean hasNext = false;
        private boolean hasPrevious = false;
        
        private int index = 0;
        
        @Override
        public boolean hasNext() {

            if (!this.hasNext) {
                while(this.iter.hasNext()) {
                    this.hasNext = FilterList.this.pred.call(this.iter.peekNext());
                    if (this.hasNext) break;
                    this.iter.next();
                    this.hasPrevious = false;
                }
            }

            return this.hasNext;
        }

        @Override
        public boolean hasPrevious() {

            if (!this.hasPrevious) {
                while(this.iter.hasPrevious()) {
                    this.hasPrevious = FilterList.this.pred.call(this.iter.peekPrevious());
                    if (this.hasPrevious) break;
                    this.iter.previous();
                    this.hasNext = false;
                }
            }

            return this.hasPrevious;
        }

        @Override
        public E next() {

            if (!this.hasNext) {
                while(true) {
                    this.hasNext = FilterList.this.pred.call(this.iter.peekNext());
                    if (this.hasNext) break;
                    this.iter.next();
                    this.hasPrevious = false;
                }
            }
            
            final E next = this.iter.next();
            
            this.hasNext = false;
            this.hasPrevious = true;
            ++this.index;
            
            return next;
        }

        @Override
        public E previous() {
            
            if (!this.hasPrevious) {
                while(true) {
                    this.hasPrevious = FilterList.this.pred.call(this.iter.peekPrevious());
                    if (this.hasPrevious) break;
                    this.iter.previous();
                    this.hasNext = false;
                }
            }
            
            final E previous = this.iter.previous();
            
            this.hasNext = true;
            this.hasPrevious = false;
            --this.index;
            
            return previous;
        }
        
        @Override
        public int nextIndex() {

            return this.index;
        }

        @Override
        public int previousIndex() {

            return this.index - 1;
        }

        @Override
        public void add(@SuppressWarnings("unused") E e) {

            throw new UnsupportedOperationException();
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
     * @since 03.10.2009
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
     * @since 03.10.2009
     */
    @Override
    public ListIterator<E> listIterator(int index) {
    
        try {
            
            return forward(listIterator(), index);
            
        } catch (NoSuchElementException e) {
            
            throw new IndexOutOfBoundsException();
        }
    }
    
    class _Iterator implements Iterator<E> {

        private final Iterator<? extends E> iter = FilterList.this.delegee.iterator();
        
        private boolean hasNext = false;
        private E next;
        
        public boolean hasNext() {

            while (!this.hasNext && this.iter.hasNext()) {
                this.next = this.iter.next();
                this.hasNext = FilterList.this.pred.call(this.next);
            }

            return this.hasNext;
        }

        public E next() {

            while (!this.hasNext) {
                this.next = this.iter.next();
                this.hasNext = FilterList.this.pred.call(this.next);
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
     * @see java.util.AbstractList#iterator()
     * @author Thomas
     * @since 03.10.2009
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
     * @since 03.10.2009
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

    @Override
    public boolean addAll(@SuppressWarnings("unused") int index, @SuppressWarnings("unused") Collection<? extends E> c) {

        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {

        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(@SuppressWarnings("unused") Collection<? extends E> c) {

        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {

        for (E element : this.delegee) {
            if (this.pred.call(element)) {
                
                return false;
            }
        }
        
        return true;
    }

    @Override
    public boolean remove(@SuppressWarnings("unused") Object o) {

        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(@SuppressWarnings("unused") Collection<?> c) {

        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(@SuppressWarnings("unused") Collection<?> c) {

        throw new UnsupportedOperationException();
    }

}
