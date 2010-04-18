<#include "*/macros/macros.ftl">
<@pp.dropOutputFile />
<#list 0..max as i>
<@pp.changeOutputFile name="AtLeastFunction" + i + ".java" />
/**
 * $Id$
 *
 * Copyright (c) 2005 Thomas Beckmann 
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
package com.thomas.functional.functions;

<#list i..max as j>
import com.thomas.functional.function.Function${j};
</#list>

/**
 * TODO Type documentation
 * 
 * @author Thomas
 * @since 06.10.2005
 */
public abstract class AtLeastFunction${i}<R<#if 0 < i><#list 1..i as j>, T${j}</#list></#if>>
        implements<@csv i..max; j>
        Function${j}<R<#if 0 < j><#list 1..j as k>, <#if i < k>Object<#else>T${k}</#if></#list></#if>></@csv> {

<#if 0 < i>
    public abstract R call(<@csv 1..i; j>T${j} arg${j}</@csv>);
    
</#if>
<#if i < max><#list (i + 1)..max as j>
    public R call(<@csv 1..j; k>
            <#if i < k>Object<#else>T${k}</#if> arg${k}</@csv>) {

        return call(<#if 0 < i><@csv 1..i; k>arg${k}</@csv></#if>);
    }

</#list></#if>
}
</#list>
