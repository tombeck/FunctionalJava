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

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 21.02.2009
 */
final class ConcatList<E> extends AbstractList<E> {

    final List<? extends E> delegee1;
    final List<? extends E> delegee2;
    
    public ConcatList(List<? extends E> base1, List<? extends E> base2) {

        if (base1 == null) throw new NullPointerException();
        if (base2 == null) throw new NullPointerException();
        
        this.delegee1 = base1;
        this.delegee2 = base2;
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

        final int size = this.delegee1.size();
        
        return index < size ? (E)this.delegee1.get(index) : (E)this.delegee2.get(index - size);
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

        return this.delegee1.size() + this.delegee2.size();
    }

    @Override
    public int indexOf(Object o) {

        int ret = this.delegee1.indexOf(o);

        if (ret < 0) {
            
            ret = this.delegee2.indexOf(o);
            
            return ret < 0 ? ret : ret + this.delegee1.size();
        }

        return ret;
    }

    @Override
    public int lastIndexOf(Object o) {

        int ret = this.delegee2.lastIndexOf(o);

        return ret < 0 ? this.delegee1.lastIndexOf(o) : ret + this.delegee1.size();
    }

    class _Iterator implements Iterator<E> {

        private final Iterator<? extends E> iter1 = ConcatList.this.delegee1.iterator();
        private final Iterator<? extends E> iter2 = ConcatList.this.delegee2.iterator();

        public boolean hasNext() {

            return this.iter1.hasNext() || this.iter2.hasNext();
        }

        public E next() {

            return (this.iter1.hasNext() ? this.iter1 : this.iter2).next();
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

        private final ListIterator<? extends E> iter1;
        private final ListIterator<? extends E> iter2;
        
        public _ListIterator() {
            
            this.iter1 = ConcatList.this.delegee1.listIterator();
            this.iter2 = ConcatList.this.delegee2.listIterator();
        }
        
        public _ListIterator(int index) {
            
            final int size = ConcatList.this.delegee1.size();
            
            if (index < size) {
                this.iter1 = ConcatList.this.delegee1.listIterator(index);
                this.iter2 = ConcatList.this.delegee2.listIterator();
            } else {
                this.iter1 = ConcatList.this.delegee1.listIterator(size);
                this.iter2 = ConcatList.this.delegee2.listIterator(index - size);
            }
        }
        
        public boolean hasNext() {

            return this.iter1.hasNext() || this.iter2.hasNext();
        }

        public E next() {

            return (this.iter1.hasNext() ? this.iter1 : this.iter2).next();
        }

        public boolean hasPrevious() {

            return this.iter2.hasPrevious() || this.iter1.hasPrevious();
        }

        public E previous() {

            return (this.iter2.hasPrevious() ? this.iter2 : this.iter1).previous();
        }

        public int nextIndex() {

            return this.iter1.hasNext() ? this.iter1.nextIndex() : this.iter2.nextIndex() + ConcatList.this.delegee1.size();
        }

        public int previousIndex() {

            return this.iter2.hasPrevious() ? this.iter2.previousIndex() + ConcatList.this.delegee1.size() : this.iter1.previousIndex();
        }

        public void remove() {

            throw new UnsupportedOperationException();
        }

        public void set(E o) {

            throw new UnsupportedOperationException();
        }

        public void add(E o) {

            throw new UnsupportedOperationException();
        }
        
    }
    
    @Override
    public ListIterator<E> listIterator() {

        return new _ListIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {

        return new _ListIterator(index);
    }

    @Override
    public boolean contains(Object o) {

        return this.delegee1.contains(o) || this.delegee2.contains(o);
    }

    @Override
    public boolean isEmpty() {

        return this.delegee1.isEmpty() && this.delegee2.isEmpty();
    }

}
