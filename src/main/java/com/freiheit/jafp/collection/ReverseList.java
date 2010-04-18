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

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 17.05.2007
 */
final class ReverseList<E> extends AbstractList<E> {

    final List<E> delegee;

    public ReverseList(List<E> base) {

        this.delegee = base;
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

        return this.delegee.get(this.delegee.size() - (index + 1));
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
    public int indexOf(Object o) {

        int lastIndex = this.delegee.lastIndexOf(o);
        
        return lastIndex == -1 ? -1 : this.delegee.size() - (lastIndex + 1);
    }

    @Override
    public Iterator<E> iterator() {

        return listIterator();
    }

    @Override
    public int lastIndexOf(Object o) {

        int index = this.delegee.indexOf(o);
        
        return index == -1 ? -1 : this.delegee.size() - (index + 1);
    }

    @Override
    public ListIterator<E> listIterator() {

        return listIterator(0);
    }

    private class _ListIterator implements ListIterator<E> {

        private final ListIterator<E> iter;

        public _ListIterator(int index) {

            this.iter = ReverseList.this.delegee.listIterator(ReverseList.this.delegee.size() - index);
        }

        public boolean hasNext() {

            return this.iter.hasPrevious();
        }

        public E next() {

            return this.iter.previous();
        }

        public boolean hasPrevious() {

            return this.iter.hasNext();
        }

        public E previous() {

            return this.iter.next();
        }

        public int nextIndex() {

            return ReverseList.this.delegee.size() - this.iter.nextIndex();
        }

        public int previousIndex() {

            return nextIndex() - 1;
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

    @Override
    public boolean contains(Object o) {

        return this.delegee.contains(o);
    }

    @Override
    public boolean isEmpty() {

        return this.delegee.isEmpty();
    }

}
