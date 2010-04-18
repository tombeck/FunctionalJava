<#include "*/macros/macros.ftl">
<@pp.dropOutputFile />
<#list 1..max as i>
<@pp.changeOutputFile name="Transform" + i + "Collection.java" />
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
package com.thomas.functional.collection;

<#if 1 < i>
import static java.lang.Math.min;

</#if>
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

import com.thomas.functional.function.Function${i};

/**
 * TODO Type documentation
 *
 * @author Thomas
 * @since 10.11.2006
 */
public class Transform${i}Collection<E, <@csv 1..i; j>T${j}</@csv>> extends AbstractCollection<E> {

    final Function${i}<? extends E, <@csv 1..i; j>? super T${j}</@csv>> func;
<#list 1..i as j>
    final Collection<? extends T${j}> delegee${j};
</#list>

    /**
     * TODO Ctor documentation
     * 
     * @param func
<#list 1..i as j>
     * @param base${j}
</#list>
     * @author Thomas
     * @since 07.10.2006
     */
    public Transform${i}Collection(
            Function${i}<? extends E, <@csv 1..i; j>? super T${j}</@csv>> func,<@csv 1..i; j>
            Collection<? extends T${j}> base${j}</@csv>) {

        if (func == null) throw new NullPointerException();
<#list 1..i as j>
        if (base${j} == null) throw new NullPointerException();
</#list>
        
        this.func = func;
<#list 1..i as j>
        this.delegee${j} = base${j};
</#list>
    }

    class _Iterator implements Iterator<E> {

<#list 1..i as j>
        private final Iterator<? extends T${j}> iter${j} = Transform${i}Collection.this.delegee${j}.iterator();
</#list>

        public boolean hasNext() {

            return <@seplist range=1..i sep=" && "; j>this.iter${j}.hasNext()</@seplist>;
        }

        public E next() {

            return Transform${i}Collection.this.func.call(<@csv 1..i; j>this.iter${j}.next()</@csv>);
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
     * @since 07.10.2006
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
     * @since 07.10.2006
     */
    @Override
    public int size() {

<#macro recurse n><#if n = 1>this.delegee${n}.size()<#else>min(this.delegee${n}.size(), <@recurse n-1/>)</#if></#macro>
        return <@recurse i/>;
    }

    /**
     * TODO Method documentation
     * 
     * @return
     * @see java.util.AbstractCollection#isEmpty()
     * @author Thomas
     * @since 27.05.2008
     */
    @Override
    public boolean isEmpty() {

        return <@seplist range=1..i sep=" || "; j>this.delegee${j}.isEmpty()</@seplist>;
    }

}
</#list>
