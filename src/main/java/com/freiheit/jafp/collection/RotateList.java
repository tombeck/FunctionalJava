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
package com.freiheit.jafp.collection;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 17.05.2007
 */
final class RotateList<E> extends AbstractList<E> {

    final List<E> delegee;
    
    final int offset;

    public RotateList(int offset, List<E> base) {

        if (base == null) throw new NullPointerException();
        
        this.delegee = base;
        this.offset = offset;
    }

    /**
     * TODO Method documentation
     * 
     * @param index
     * @return
     * @see java.util.AbstractList#get(int)
     * @author Thomas
     * @since 21.10.2006
     */
    @Override
    public E get(int index) {

        final int size = this.delegee.size();
        
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        
        index = (int)(((long)index - this.offset) % size);

        return this.delegee.get(index < 0 ? index + size : index);
    }

    static int getOffset(int offset, int size) {
        
        if (size == 0) return 0;
        
        offset = offset % size;
        offset *= -1;

        return offset < 0 ? offset + size : offset;
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.AbstractCollection#size()
     * @author Thomas
     * @since 21.10.2006
     */
    @Override
    public int size() {

        return this.delegee.size();
    }

    @Override
    public boolean isEmpty() {

        return this.delegee.isEmpty();
    }

    class _Iterator implements Iterator<E> {

        private final int mid;
        private final Iterator<E> iter1;
        private final ListIterator<E> iter2;

        public _Iterator() {
            
            final int size = RotateList.this.delegee.size();
            
            this.mid = getOffset(RotateList.this.offset, size);
            if (this.mid > size) {
                this.iter1 = RotateList.this.delegee.listIterator(size);
                this.iter2 = RotateList.this.delegee.listIterator(this.mid - size);
            } else {
                this.iter1 = RotateList.this.delegee.listIterator(this.mid);
                this.iter2 = RotateList.this.delegee.listIterator();
            }
        }
        
        public boolean hasNext() {

            return this.iter2.nextIndex() < this.mid;
        }

        public E next() {

            if (this.iter1.hasNext()) return this.iter1.next();
            if (this.iter2.nextIndex() < this.mid) return this.iter2.next();

            throw new NoSuchElementException();
        }

        public void remove() {

            throw new UnsupportedOperationException();
        }

    }
    
    @Override
    public Iterator<E> iterator() {

        return new _Iterator();
    }

    class _ListIterator implements ListIterator<E> {

        private final int mid;
        private final ListIterator<E> iter1;
        private final ListIterator<E> iter2;

        public _ListIterator(int index) {
            
            final int size = RotateList.this.delegee.size();
            
            this.mid = getOffset(RotateList.this.offset, size);
            if (this.mid + index > size) {
                this.iter1 = RotateList.this.delegee.listIterator(size);
                this.iter2 = RotateList.this.delegee.listIterator((index + this.mid) - size);
            } else {
                this.iter1 = RotateList.this.delegee.listIterator(index + this.mid);
                this.iter2 = RotateList.this.delegee.listIterator();
            }
        }
        
        public boolean hasNext() {

            return this.iter2.nextIndex() < this.mid;
        }

        public E next() {

            if (this.iter1.hasNext()) return this.iter1.next();
            if (this.iter2.nextIndex() < this.mid) return this.iter2.next();

            throw new NoSuchElementException();
        }

        public boolean hasPrevious() {

            return this.iter1.nextIndex() > this.mid;
        }

        public E previous() {

            if (this.iter2.hasPrevious()) return this.iter2.previous();
            if (this.iter1.nextIndex() > this.mid) return this.iter1.previous();

            throw new NoSuchElementException();
        }

        public int nextIndex() {

            if (this.iter1.hasNext()) return this.iter1.nextIndex() - this.mid;
            return this.iter2.nextIndex() + this.mid;
        }

        public int previousIndex() {

            if (this.iter2.hasPrevious()) return this.iter2.previousIndex() + this.mid;
            return this.iter1.previousIndex() - this.mid;
        }

        public void remove() {

            throw new UnsupportedOperationException();
        }

        public void set(@SuppressWarnings("unused") E o) {

            throw new UnsupportedOperationException();
        }

        public void add(@SuppressWarnings("unused") E o) {

            throw new UnsupportedOperationException();
        }
        
    }
    
    @Override
    public ListIterator<E> listIterator(int index) {

        return new _ListIterator(index);
    }

}
