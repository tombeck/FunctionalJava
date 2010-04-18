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

import com.thomas.functional.collection.util.iterator.LookAheadIterator;
import com.thomas.functional.function.Function2;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 12.05.2007
 */
final class MergeCollection<E> extends AbstractCollection<E> {

    final Collection<? extends E> delegee1;
    final Collection<? extends E> delegee2;
    final Function2<? extends Boolean, ? super E, ? super E> less;

    /**
     * TODO Ctor documentation
     * 
     * @param base1
     * @param base2
     * @param less
     * 
     * @author Thomas
     * @since 28.12.2005
     */
    public MergeCollection(
            Function2<? extends Boolean, ? super E, ? super E> less,
            Collection<? extends E> base1,
            Collection<? extends E> base2) {

        if (less == null) throw new NullPointerException();
        if (base1 == null) throw new NullPointerException();
        if (base2 == null) throw new NullPointerException();

        this.delegee1 = base1;
        this.delegee2 = base2;
        this.less = less;
    }

    class _Iterator implements Iterator<E> {

        private final LookAheadIterator<E> iter1 = new LookAheadIterator<E>(MergeCollection.this.delegee1.iterator());
        private final LookAheadIterator<E> iter2 = new LookAheadIterator<E>(MergeCollection.this.delegee2.iterator());

        public boolean hasNext() {

            return this.iter1.hasNext() || this.iter2.hasNext();
        }

        public E next() {

            return ((this.iter2.hasNext()
                    && (!this.iter1.hasNext() || MergeCollection.this.less.call(
                            this.iter2.peekNext(),
                            this.iter1.peekNext())))
                            ? this.iter2 : this.iter1).next();
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
     * @since 12.05.2007
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
     * @since 12.05.2007
     */
    @Override
    public int size() {

        return this.delegee1.size() + this.delegee2.size();
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.AbstractCollection#isEmpty()
     * @author Thomas
     * @since 12.05.2007
     */
    @Override
    public boolean isEmpty() {

        return this.delegee1.isEmpty() && this.delegee2.isEmpty();
    }

}
