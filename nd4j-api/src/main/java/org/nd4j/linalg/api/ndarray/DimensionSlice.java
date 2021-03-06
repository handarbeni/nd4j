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

package org.nd4j.linalg.api.ndarray;

import java.io.Serializable;
import java.util.Arrays;

/**
 * A POJO for handling iterating over dimensions.
 *
 * @author Adam Gibson
 */
public class DimensionSlice implements Serializable {
    private boolean nextSlice;
    private Object result;
    private boolean modify = false;
    private int[] indices;

    public DimensionSlice(boolean nextSlice, Object result, int[] indices) {
        this.nextSlice = nextSlice;
        this.result = result;
        this.indices = indices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DimensionSlice)) return false;

        DimensionSlice that = (DimensionSlice) o;

        if (nextSlice != that.nextSlice) return false;
        if (!Arrays.equals(indices, that.indices)) return false;
        if (result != null ? !result.equals(that.result) : that.result != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result1 = (nextSlice ? 1 : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (indices != null ? Arrays.hashCode(indices) : 0);
        return result1;
    }

    public boolean isNextSlice() {

        return nextSlice;
    }

    public void setNextSlice(boolean nextSlice) {
        this.nextSlice = nextSlice;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public int[] getIndices() {
        return indices;
    }

    public void setIndices(int[] indices) {
        this.indices = indices;
    }

    public boolean isModify() {
        return modify;
    }

    public void setModify(boolean modify) {
        this.modify = modify;
    }

    @Override
    public String toString() {
        return "DimensionSlice{" +
                "nextSlice=" + nextSlice +
                ", result=" + result +
                ", indices=" + Arrays.toString(indices) +
                '}';
    }
}
