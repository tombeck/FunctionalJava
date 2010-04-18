<#include "*/macros/macros.ftl">
<@pp.dropOutputFile />
<#list 0..max as i>
<@pp.changeOutputFile name="Function" + i + ".java" />
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
package com.thomas.functional.function;

<#if i = 0>
import java.util.concurrent.Callable;

</#if>
/**
 * TODO Type documentation
 *
 * @author Thomas
 * @since 04.10.2005
 */
<#if i = 0>
public interface Function0<R> extends Callable<R> {

    public R call();

}
<#else>
public interface Function${i}<R, <@csv 1..i; j>T${j}</@csv>> {

    public R call(<@csv 1..i; j>T${j} arg${j}</@csv>);
    
}
</#if>
</#list>
