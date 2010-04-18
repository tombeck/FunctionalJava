<#include "*/macros/macros.ftl">
<@pp.dropOutputFile />
<#list 1..max as i>
<@pp.changeOutputFile name="_Tuple" + i + ".java" />
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
package com.freiheit.jafp.functions.tuple;

import com.freiheit.jafp.function.Function1;<#if 1 < i>
import com.freiheit.jafp.function.Function${i};</#if>
import com.freiheit.jafp.tuple.Tuple${i};

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 01.01.2007
 */
public class _Tuple${i} <#if 1 < i>extends _Tuple${i - 1}</#if> {

    public static final class Tuple${i}_<<@csv 1..i; j>T${j}</@csv>>
            implements Function${i}<Tuple${i}<<@csv 1..i; j>T${j}</@csv>>, <@csv 1..i; j>T${j}</@csv>> {

        public static final Tuple${i}_<<@csv 1..i; j>Object</@csv>> INSTANCE = new Tuple${i}_<<@csv 1..i; j>Object</@csv>>();

        public Tuple${i}<<@csv 1..i; j>T${j}</@csv>> call(<@csv 1..i; j>T${j} arg${j}</@csv>) {

            return new Tuple${i}<<@csv 1..i; j>T${j}</@csv>>(<@csv 1..i; j>arg${j}</@csv>);
        }

    }

    public static final class GetArg${i}_<T${i}>
            implements Function1<T${i}, Tuple${i}<<@csv 1..i; j>?<#if j = i> extends T${i}</#if></@csv>>> {

        public static final GetArg${i}_<Object> INSTANCE = new GetArg${i}_<Object>();

        public T${i} call(Tuple${i}<<@csv 1..i; j>?<#if j = i> extends T${i}</#if></@csv>> arg1) {
            
            return arg1.getArg${i}();
        }
        
    }
    
    @SuppressWarnings("unchecked")
    public static <<@csv 1..i; j>T${j}</@csv>> Function${i}<Tuple${i}<<@csv 1..i; j>T${j}</@csv>>, <@csv 1..i; j>T${j}</@csv>> tuple${i}_() {

        return (Tuple${i}_<<@csv 1..i; j>T${j}</@csv>>)Tuple${i}_.INSTANCE;
    }

    @SuppressWarnings("unchecked")
    public static <T${i}> Function1<T${i}, Tuple${i}<<@csv 1..i; j>?<#if j = i> extends T${i}</#if></@csv>>> getArg${i}_() {

        return (GetArg${i}_<T${i}>)GetArg${i}_.INSTANCE;
    }

}
</#list>
