<#include "*/macros/macros.ftl">
<@pp.dropOutputFile />
<#list 1..max as i>
<@pp.changeOutputFile name="Tuple" + i + ".java" />
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
package com.thomas.functional.tuple;

import java.io.Serializable;
import java.util.AbstractList;

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 02.02.2007
 */
public class Tuple${i}<<@csv 1..i; j>T${j}</@csv>> extends AbstractList<Object>
    implements AtLeastTuple${i}<<@csv 1..i; j>T${j}</@csv>>, Serializable {

    private static final long serialVersionUID = -2579339787284544658L;

<#list 1..i as j>
    private T${j} arg${j};
</#list>
    
    public Tuple${i}() {

        this(<@csv 1..i; j>(T${j})null</@csv>);
    }

    public Tuple${i}(AtLeastTuple${i}<<@csv 1..i; j>? extends T${j}</@csv>> source) {

        this(<@csv 1..i; j>source.getArg${j}()</@csv>);
    }

    public Tuple${i}(<@csv 1..i; j>T${j} arg${j}</@csv>) {

<#list 1..i as j>
        setArg${j}(arg${j});
</#list>
    }

<#list 1..i as j>
    /**
     * @return Returns the arg${j}.
     */
    public T${j} getArg${j}() {
        
        return this.arg${j};
    }
    
    /**
     * @param arg2 The arg${j} to set.
     */
    public void setArg${j}(T${j} arg${j}) {
        
        this.arg${j} = arg${j};
    }

</#list>
    @Override
    public Object get(int index) {
    
        switch (index) {
<#list 1..i as j>
        case ${j - 1}: return getArg${j}();
</#list>
        default: throw new IndexOutOfBoundsException();
        }
    }
    
    @Override
    public int size() {
        
        return ${i};
    }
    
    @Override
    public String toString() {
    
        return "["<#list 1..i as j><#if 1 < j> + ", "</#if> + getArg${j}()</#list> + "]";
    }
	
	@Override
    public boolean equals(Object obj) {
    
        if (obj == this) return true;
        if (!(obj instanceof Tuple${i})) return false;
        
        final Tuple${i}<<@csv 1..i>?</@csv>> other = (Tuple${i}<<@csv 1..i>?</@csv>>)obj;
        
        boolean ret = true;

<#list 1..i as j>
        ret &= (getArg${j}() == null ? other.getArg${j}() == null : getArg${j}().equals(other.getArg${j}()));
</#list>
    
        return ret;
    }

    @Override
    public int hashCode() {
    
        int ret = 1;

<#list 1..i as j>
        ret = 37 * ret + (getArg${j}() == null ? 0 : getArg${j}().hashCode());
</#list>
    
        return ret;
    }

}
</#list>
