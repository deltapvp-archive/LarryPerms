/*
 * Copyright (c) 2016 Lucko (Luck) <luck@lucko.me>
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package me.lucko.luckperms.sponge.contexts;

import lombok.AllArgsConstructor;
import me.lucko.luckperms.api.context.ContextCalculator;
import me.lucko.luckperms.api.context.MutableContextSet;
import me.lucko.luckperms.sponge.service.LuckPermsService;
import org.spongepowered.api.service.context.Context;
import org.spongepowered.api.service.permission.Subject;

import java.util.Map;
import java.util.Set;

@AllArgsConstructor
public class SpongeCalculatorLink extends ContextCalculator<Subject> {
    private final org.spongepowered.api.service.context.ContextCalculator<Subject> calculator;

    @Override
    public MutableContextSet giveApplicableContext(Subject subject, MutableContextSet accumulator) {
        Set<Context> contexts = LuckPermsService.convertContexts(accumulator);
        calculator.accumulateContexts(subject, contexts);

        accumulator.clear();
        accumulator.addAll(LuckPermsService.convertContexts(contexts));
        return accumulator;
    }

    @Override
    public boolean isContextApplicable(Subject subject, Map.Entry<String, String> context) {
        Context c = new Context(context.getKey(), context.getValue());
        return calculator.matches(c, subject);
    }
}