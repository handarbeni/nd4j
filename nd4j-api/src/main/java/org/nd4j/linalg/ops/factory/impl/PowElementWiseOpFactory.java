/*
 * Copyright 2015 Skymind,Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.nd4j.linalg.ops.factory.impl;

import org.nd4j.linalg.ops.ElementWiseOp;
import org.nd4j.linalg.ops.transforms.Pow;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by agibsonccc on 12/11/14.
 */
public class PowElementWiseOpFactory extends BaseElementWiseOpFactory {

    private static Map<Double, ElementWiseOp> FUNCTIONS = new ConcurrentHashMap<>();
    private double pow = 0.0;

    @Override
    public ElementWiseOp create(Object[] args) {
        if (args != null && args.length > 0)
            this.pow = Double.valueOf(args[0].toString());
        if (FUNCTIONS.containsKey(pow))
            return FUNCTIONS.get(pow);
        else {
            ElementWiseOp ret = new Pow(args);
            FUNCTIONS.put(pow, ret);
            return ret;
        }
    }

    @Override
    public ElementWiseOp create() {
        if (FUNCTIONS.containsKey(pow))
            return FUNCTIONS.get(pow);
        else {
            ElementWiseOp ret = new Pow(pow);
            FUNCTIONS.put(pow, ret);
            return ret;
        }
    }
}
