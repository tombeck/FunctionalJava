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

import static com.thomas.functional.collection.util.iterator.Iterators.emptyIterator;
import static com.thomas.functional.collection.util.iterator.Iterators.forward;
import static com.thomas.functional.collection.util.iterator.Iterators.unmodifiableIterator;
import static java.lang.Math.max;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * TODO Type documentation
 *
 * @author Thomas
 * @since 19.07.2009
 */
final class DropCollection<E> extends AbstractCollection<E> {

    private final Collection<E> base;
    private final int count;

    public DropCollection(Collection<E> base, int count) {

        if (base == null) throw new NullPointerException();
        if (count < 0) throw new IllegalArgumentException();
        
        this.base = base;
        this.count = count;
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.AbstractCollection#iterator()
     * @author Thomas
     * @since 19.07.2009
     */
    @Override
    public Iterator<E> iterator() {

        try {
            
            return unmodifiableIterator(forward(this.base.iterator(), this.count));
            
        } catch (NoSuchElementException e) {
            
            return emptyIterator();
        }
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.AbstractCollection#size()
     * @author Thomas
     * @since 19.07.2009
     */
    @Override
    public int size() {

        return max(this.base.size() - this.count, 0);
    }

}
