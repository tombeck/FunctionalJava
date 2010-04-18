<#include "*/macros/macros.ftl">
<@pp.dropOutputFile />
<#list 2..max as i>
<@pp.changeOutputFile name="Join" + i + "Collection.java" />
/**
 * $Id$
 *
 * Copyright (c) 2008 Thomas Beckmann 
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

import com.thomas.functional.collection.util.iterator.EmptyIterator;
import com.thomas.functional.function.Function${i};

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 16.05.2008
 */
public class Join${i}Collection<E, <@csv 1..i; j>T${j}</@csv>> extends AbstractCollection<E> {

    final Function${i}<? extends E, <@csv 1..i; j>? super T${j}</@csv>> func;
<#list 1..i as j>
    final Collection<? extends T${j}> base${j};
</#list>

    /**
     * TODO Ctor documentation
     * 
     * @param func
<#list 1..i as j>
     * @param base${j}
</#list>
     * @author Thomas
     * @since 28.05.2006
     */
    public Join${i}Collection(
            Function${i}<? extends E, <@csv 1..i; j>? super T${j}</@csv>> func,<@csv 1..i; j>
            Collection<? extends T${j}> base${j}</@csv>) {

        if (func == null) throw new NullPointerException();
<#list 1..i as j>
        if (base${j} == null) throw new NullPointerException();
</#list>

        this.func = func;
<#list 1..i as j>
        this.base${j} = base${j};
</#list>
    }

    class _Iterator implements Iterator<E> {

<#list 1..i as j>
        private Iterator<? extends T${j}> iter${j} = Join${i}Collection.this.base${j}.iterator();
</#list>
<#list 1..(i-1) as j>
        private T${j} next${j} = this.iter${j}.next();
</#list>

        public boolean hasNext() {

            return <@seplist range=1..i sep=" || "; j>this.iter${j}.hasNext()</@seplist>;
        }

        public E next() {

<#list i..2 as j>
            if (!this.iter${j}.hasNext()) {
</#list>
<#list 1..(i-1) as j>
                this.next${j} = this.iter${j}.next();
                this.iter${j+1} = Join${i}Collection.this.base${j+1}.iterator();
            }
</#list>

            return Join${i}Collection.this.func.call(<@csv 1..(i-1); j>this.next${j}</@csv>, this.iter${i}.next());
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
     * @since 28.05.2006
     */
    @Override
    public Iterator<E> iterator() {

        return isEmpty() ? new EmptyIterator<E>() : new _Iterator();
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.AbstractCollection#size()
     * @author Thomas
     * @since 28.05.2006
     */
    @Override
    public int size() {

        return <@seplist range=1..i sep=" * "; j>this.base${j}.size()</@seplist>;
    }

    @Override
    public boolean isEmpty() {

        return <@seplist range=1..i sep=" || "; j>this.base${j}.isEmpty()</@seplist>;
    }

}
</#list>
