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

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 16.02.2009
 */
final class ConcatCollection<E> extends AbstractCollection<E> {

    final Collection<? extends E> delegee1;
    final Collection<? extends E> delegee2;

    public ConcatCollection(
            Collection<? extends E> base1,
            Collection<? extends E> base2) {

        if (base1 == null) throw new NullPointerException();
        if (base2 == null) throw new NullPointerException();

        this.delegee1 = base1;
        this.delegee2 = base2;
    }

    class _Iterator implements Iterator<E> {

        private final Iterator<? extends E> iter1 = ConcatCollection.this.delegee1.iterator();
        private final Iterator<? extends E> iter2 = ConcatCollection.this.delegee2.iterator();

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

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.AbstractCollection#iterator()
     * @author Thomas
     * @since 17.10.2006
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
     * @since 17.10.2006
     */
    @Override
    public int size() {

        return this.delegee1.size() + this.delegee2.size();
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
