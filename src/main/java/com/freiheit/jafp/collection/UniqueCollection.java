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

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

import com.freiheit.jafp.function.Function2;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 12.05.2007
 */
final class UniqueCollection<E> extends AbstractCollection<E> {

    final Collection<? extends E> delegee;
    final Function2<? extends Boolean, ? super E, ? super E> equal;

    /**
     * TODO Ctor documentation
     * 
     * @param base
     * @param equal
     * @author Thomas
     * @since 27.12.2005
     */
    public UniqueCollection(
            Function2<? extends Boolean, ? super E, ? super E> equal,
            Collection<? extends E> base) {

        if (base == null) throw new NullPointerException();
        if (equal == null) throw new NullPointerException();

        this.delegee = base;
        this.equal = equal;
    }

    class _Iterator implements Iterator<E> {

        private final Iterator<? extends E> iter = UniqueCollection.this.delegee.iterator();
        
        private boolean hasNext = this.iter.hasNext();
        private E next = this.hasNext ? this.iter.next() : null;

        public boolean hasNext() {

            final E previous = this.next;

            while (!this.hasNext && this.iter.hasNext()) {
                this.next = this.iter.next();
                this.hasNext = !UniqueCollection.this.equal.call(previous, this.next);
            }

            return this.hasNext;
        }

        public E next() {

            final E previous = this.next;

            while (!this.hasNext) {
                this.next = this.iter.next();
                this.hasNext = !UniqueCollection.this.equal.call(previous, this.next);
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
     * @since 27.12.2005
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
     * @since 27.12.2005
     */
    @Override
    public int size() {

        int ret = 0;

        for (Iterator<E> i = iterator(); i.hasNext(); i.next()) {
            ++ret;
        }

        return ret;
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

        return this.delegee.isEmpty();
    }

}
