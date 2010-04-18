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

import static com.freiheit.jafp.tuple.Tuples.asPair;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.freiheit.jafp.tuple.Pair;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 21.02.2009
 */
final class IndexedList<E> extends AbstractList<Pair<Integer, E>> {

    final List<? extends E> delegee;
    
    public IndexedList(List<? extends E> base) {

        this.delegee = base;
    }

    private class _ListIterator implements ListIterator<Pair<Integer, E>> {
        
        private final ListIterator<? extends E> iter;
        
        public _ListIterator() {
            
            this.iter = IndexedList.this.delegee.listIterator();
        }
        
        public _ListIterator(int index) {
            
            this.iter = IndexedList.this.delegee.listIterator(index);
        }

        @Override
        public void add(@SuppressWarnings("unused")Pair<Integer, E> e) {

            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {

            return this.iter.hasNext();
        }

        @Override
        public boolean hasPrevious() {

            return this.iter.hasPrevious();
        }

        @Override
        public Pair<Integer, E> next() {

            final int index = nextIndex();

            return asPair(index, (E)this.iter.next());
        }

        @Override
        public int nextIndex() {

            return this.iter.nextIndex();
        }

        @Override
        public Pair<Integer, E> previous() {

            final int index = previousIndex();

            return asPair(index, (E)this.iter.previous());
        }

        @Override
        public int previousIndex() {

            return this.iter.previousIndex();
        }

        @Override
        public void remove() {

            throw new UnsupportedOperationException();
        }

        @Override
        public void set(@SuppressWarnings("unused") Pair<Integer, E> e) {

            throw new UnsupportedOperationException();
        }
        
    }
    
    @Override
    public Iterator<Pair<Integer, E>> iterator() {

        return listIterator();
    }

    @Override
    public ListIterator<Pair<Integer, E>> listIterator() {

        return new _ListIterator();
    }

    @Override
    public ListIterator<Pair<Integer, E>> listIterator(int index) {

        return new _ListIterator(index);
    }

    /**
     * TODO Method documentation
     * 
     * @param index
     * @return
     * @see java.util.AbstractList#get(int)
     * @author Thomas
     * @since 21.02.2009
     */
    @Override
    public Pair<Integer, E> get(int index) {

        return asPair(index, (E)this.delegee.get(index));
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.AbstractCollection#size()
     * @author Thomas
     * @since 21.02.2009
     */
    @Override
    public int size() {

        return this.delegee.size();
    }

    @Override
    public boolean isEmpty() {

        return this.delegee.isEmpty();
    }

}
