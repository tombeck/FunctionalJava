/**
 * $Id$
 *
 * Copyright (c) 2006 Thomas Beckmann 
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
package com.thomas.functional.collection.util.iterator;

import java.util.ListIterator;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 17.12.2006
 */
public class LookAheadListIterator<E> implements ListIterator<E> {

    /*
     * NONE_CACHED : neither previous nor next value is cached
     * PREV_CACHED : previous value is cached but next is not
     * NEXT_CACHED : next value is cached but previous is not
     * BOTH_CACHED : both next and previous value is cached
     * 
     * EVEN        : the base iterator points to the same position as this iterator
     * BEHIND      : the base iterator is one position behind this iterator
     * AHEAD       : the base iterator is one position ahead of this iterator
     * 
     * HAS_NEXT    : the next value exists but may not be cached
     * HAS_PREVIOUS: the previous value exists but may not be cached
     */
    private static enum State {
        
        NONE_CACHED_EVEN,
        PREV_CACHED_EVEN,
        PREV_CACHED_BEHIND,
        PREV_CACHED_BEHIND_HAS_NEXT,
        NEXT_CACHED_EVEN,
        NEXT_CACHED_AHEAD,
        NEXT_CACHED_AHEAD_HAS_PREVIOUS,
        BOTH_CACHED_EVEN,
        BOTH_CACHED_AHEAD,
        BOTH_CACHED_BEHIND;
    }
    
    private final ListIterator<E> base;

    private E previous;
    private E next;
    private State state = State.NONE_CACHED_EVEN;

    public LookAheadListIterator(ListIterator<E> base) {

        this.base = base;
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.ListIterator#hasNext()
     * @author Thomas
     * @since 28.03.2006
     */
    public boolean hasNext() {

        switch (this.state) {
        default:
            assert false : "unknown state";
        case PREV_CACHED_EVEN:
        case NONE_CACHED_EVEN:
            return this.base.hasNext();
        case PREV_CACHED_BEHIND:
            return false;
        case BOTH_CACHED_EVEN:
        case BOTH_CACHED_AHEAD:
        case BOTH_CACHED_BEHIND:
        case NEXT_CACHED_EVEN:
        case NEXT_CACHED_AHEAD:
        case NEXT_CACHED_AHEAD_HAS_PREVIOUS:
        case PREV_CACHED_BEHIND_HAS_NEXT:
            return true;
        }
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.ListIterator#next()
     * @author Thomas
     * @since 28.03.2006
     */
    public E next() {

        switch (this.state) {
        default:
            assert false : "unknown state";
        case PREV_CACHED_BEHIND:
        case PREV_CACHED_BEHIND_HAS_NEXT:
        case BOTH_CACHED_BEHIND:
            this.base.next();
        case NONE_CACHED_EVEN:
        case PREV_CACHED_EVEN:
        case BOTH_CACHED_EVEN:
        case NEXT_CACHED_EVEN:
            this.previous = this.base.next();
            break;
        case NEXT_CACHED_AHEAD:
        case NEXT_CACHED_AHEAD_HAS_PREVIOUS:
        case BOTH_CACHED_AHEAD:
            this.previous = this.next;
            break;
        }
        this.state = State.PREV_CACHED_EVEN;

        return this.previous;
    }

    public E peekNext() {

        switch (this.state) {
        default:
            assert false : "unknown state";
        case NONE_CACHED_EVEN:
            boolean hasPrevious = this.base.hasPrevious();
            this.next = this.base.next();
            this.state = hasPrevious ? State.NEXT_CACHED_AHEAD_HAS_PREVIOUS : State.NEXT_CACHED_AHEAD;
            return this.next;
        case PREV_CACHED_BEHIND:
        case PREV_CACHED_BEHIND_HAS_NEXT:
            this.base.next();
        case PREV_CACHED_EVEN:
            this.next = this.base.next();
            this.state = State.BOTH_CACHED_AHEAD;
        case NEXT_CACHED_EVEN:
        case NEXT_CACHED_AHEAD:
        case NEXT_CACHED_AHEAD_HAS_PREVIOUS:
        case BOTH_CACHED_EVEN:
        case BOTH_CACHED_AHEAD:
        case BOTH_CACHED_BEHIND:
            return this.next;
        }
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.ListIterator#hasPrevious()
     * @author Thomas
     * @since 28.03.2006
     */
    public boolean hasPrevious() {

        switch (this.state) {
        default:
            assert false : "unknown state";
        case NONE_CACHED_EVEN:
        case NEXT_CACHED_EVEN:
            return this.base.hasPrevious();
        case NEXT_CACHED_AHEAD:
            return false;
        case NEXT_CACHED_AHEAD_HAS_PREVIOUS:
        case PREV_CACHED_EVEN:
        case PREV_CACHED_BEHIND:
        case PREV_CACHED_BEHIND_HAS_NEXT:
        case BOTH_CACHED_EVEN:
        case BOTH_CACHED_AHEAD:
        case BOTH_CACHED_BEHIND:
            return true;
        }
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.ListIterator#previous()
     * @author Thomas
     * @since 28.03.2006
     */
    public E previous() {

        switch (this.state) {
        default:
            assert false : "unknown state";
        case NEXT_CACHED_AHEAD:
        case NEXT_CACHED_AHEAD_HAS_PREVIOUS:
        case BOTH_CACHED_AHEAD:
            this.base.previous();
        case NONE_CACHED_EVEN:
        case PREV_CACHED_EVEN:
        case NEXT_CACHED_EVEN:
        case BOTH_CACHED_EVEN:
            this.next = this.base.previous();
            break;
        case PREV_CACHED_BEHIND:
        case PREV_CACHED_BEHIND_HAS_NEXT:
        case BOTH_CACHED_BEHIND:
            this.next = this.previous;
            break;
        }
        this.state = State.NEXT_CACHED_EVEN;

        return this.next;
    }

    public E peekPrevious() {

        switch (this.state) {
        default:
            assert false : "unknown state";
        case NONE_CACHED_EVEN:
            boolean hasNext = this.base.hasNext();
            this.previous = this.base.previous();
            this.state = hasNext ? State.PREV_CACHED_BEHIND_HAS_NEXT : State.PREV_CACHED_BEHIND;
            return this.previous;
        case NEXT_CACHED_AHEAD:
        case NEXT_CACHED_AHEAD_HAS_PREVIOUS:
            this.base.previous();
        case NEXT_CACHED_EVEN:
            this.previous = this.base.previous();
            this.state = State.BOTH_CACHED_BEHIND;
            return this.previous;
        case PREV_CACHED_EVEN:
        case PREV_CACHED_BEHIND:
        case PREV_CACHED_BEHIND_HAS_NEXT:
        case BOTH_CACHED_EVEN:
        case BOTH_CACHED_AHEAD:
        case BOTH_CACHED_BEHIND:
            return this.previous;
        }
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.ListIterator#nextIndex()
     * @author Thomas
     * @since 28.03.2006
     */
    public int nextIndex() {

        switch (this.state) {
        default:
            assert false : "unknown state";
        case NONE_CACHED_EVEN:
        case PREV_CACHED_EVEN:
        case NEXT_CACHED_EVEN:
        case BOTH_CACHED_EVEN:
            return this.base.nextIndex();
        case NEXT_CACHED_AHEAD:
        case NEXT_CACHED_AHEAD_HAS_PREVIOUS:
        case BOTH_CACHED_AHEAD:
            return this.base.nextIndex() - 1;
        case PREV_CACHED_BEHIND:
        case PREV_CACHED_BEHIND_HAS_NEXT:
        case BOTH_CACHED_BEHIND:
            return this.base.nextIndex() + 1;
        }
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.ListIterator#previousIndex()
     * @author Thomas
     * @since 28.03.2006
     */
    public int previousIndex() {

        switch (this.state) {
        default:
            assert false : "unknown state";
        case NONE_CACHED_EVEN:
        case PREV_CACHED_EVEN:
        case NEXT_CACHED_EVEN:
        case BOTH_CACHED_EVEN:
            return this.base.previousIndex();
        case NEXT_CACHED_AHEAD:
        case NEXT_CACHED_AHEAD_HAS_PREVIOUS:
        case BOTH_CACHED_AHEAD:
            return this.base.previousIndex() - 1;
        case PREV_CACHED_BEHIND:
        case PREV_CACHED_BEHIND_HAS_NEXT:
        case BOTH_CACHED_BEHIND:
            return this.base.previousIndex() + 1;
        }
    }

    /**
     * TODO Method documentation
     * 
     * @see java.util.ListIterator#remove()
     * @author Thomas
     * @since 28.03.2006
     */
    public void remove() {

        switch (this.state) {
        default:
            assert false : "unknown state";
        case NONE_CACHED_EVEN:
        case PREV_CACHED_EVEN:
        case NEXT_CACHED_EVEN:
            this.base.remove();
            this.state = State.NONE_CACHED_EVEN;
            break;
        case PREV_CACHED_BEHIND:
        case PREV_CACHED_BEHIND_HAS_NEXT:
        case NEXT_CACHED_AHEAD:
        case NEXT_CACHED_AHEAD_HAS_PREVIOUS:
        case BOTH_CACHED_EVEN:
        case BOTH_CACHED_AHEAD:
        case BOTH_CACHED_BEHIND:
            throw new IllegalStateException();
        }
    }

    /**
     * TODO Method documentation
     * 
     * @param o
     * @see java.util.ListIterator#set(E)
     * @author Thomas
     * @since 28.03.2006
     */
    public void set(E o) {

        switch (this.state) {
        default:
            assert false : "unknown state";
        case NONE_CACHED_EVEN:
            this.base.set(o);
            break;
        case PREV_CACHED_EVEN:
            this.base.set(o);
            this.previous = o;
            break;
        case NEXT_CACHED_EVEN:
            this.base.set(o);
            this.next = o;
            break;
        case PREV_CACHED_BEHIND:
        case PREV_CACHED_BEHIND_HAS_NEXT:
        case NEXT_CACHED_AHEAD:
        case NEXT_CACHED_AHEAD_HAS_PREVIOUS:
        case BOTH_CACHED_EVEN:
        case BOTH_CACHED_AHEAD:
        case BOTH_CACHED_BEHIND:
            throw new IllegalStateException();
        }
    }

    /**
     * TODO Method documentation
     * 
     * @param o
     * @see java.util.ListIterator#add(E)
     * @author Thomas
     * @since 28.03.2006
     */
    public void add(E o) {

        switch (this.state) {
        default:
            assert false : "unknown state";
        case PREV_CACHED_EVEN:
        case NONE_CACHED_EVEN:
            this.base.add(o);
            this.previous = o;
            this.state = State.PREV_CACHED_EVEN;
            break;
        case NEXT_CACHED_EVEN:
        case BOTH_CACHED_EVEN:
            this.base.add(o);
            this.previous = o;
            this.state = State.BOTH_CACHED_EVEN;
            break;
        case PREV_CACHED_BEHIND:
        case PREV_CACHED_BEHIND_HAS_NEXT:
        case NEXT_CACHED_AHEAD:
        case NEXT_CACHED_AHEAD_HAS_PREVIOUS:
        case BOTH_CACHED_AHEAD:
        case BOTH_CACHED_BEHIND:
            throw new IllegalStateException();
        }
    }

}
