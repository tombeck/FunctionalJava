<#include "*/macros/macros.ftl">
<@pp.dropOutputFile />
<#list 1..max as from>
<#list 0..max as to>
<@pp.changeOutputFile name="BindFrom" + from + "To" + to + ".java" />
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
package com.thomas.functional.bind;

import com.thomas.functional.function.Function${from};
<#if to != from>
import com.thomas.functional.function.Function${to};
</#if>

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 23.05.2007
 */
public final class BindFrom${from}To${to}<R, <@csv 1..from; i>T${i}</@csv>> {

    final Function${from}<R, <@csv 1..from; i>T${i}</@csv>> f0;

    BindFrom${from}To${to}(Function${from}<R, <@csv 1..from; i>T${i}</@csv>> f0) {

        if (f0 == null) throw new NullPointerException();

        this.f0 = f0;
    }

    public <#if 0<to><<@csv 1..to; j>S${j}</@csv>></#if> Function${to}<<@csv 0..to; j><#if j=0>R<#else>S${j}</#if></@csv>> bind(<@csv 1..from; i>
            final Function${to}<<@csv 0..to; j><#if j=0>? extends T${i}<#else>? super S${j}</#if></@csv>> f${i}</@csv>) {

<#list 1..from as i>
        if (f${i} == null) throw new NullPointerException();
</#list>
        
        return new Function${to}<<@csv 0..to; j><#if j=0>R<#else>S${j}</#if></@csv>>() {

            public R call(<#if 0<to><@csv 1..to; i>S${i} arg${i}</@csv></#if>) {

                return BindFrom${from}To${to}.this.f0.call(<@csv 1..from; i>f${i}.call(<#if 0<to><@csv 1..to; j>arg${j}</@csv></#if>)</@csv>);
            }

        };
    }

}
</#list>
</#list>
