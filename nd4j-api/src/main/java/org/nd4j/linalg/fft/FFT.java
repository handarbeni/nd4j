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

package org.nd4j.linalg.fft;

import org.nd4j.linalg.api.complex.IComplexNDArray;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;


/**
 * FFT and IFFT
 *
 * @author Adam Gibson
 */
public class FFT {

    /**
     * FFT along a particular dimension
     *
     * @param transform   the ndarray to transform
     * @param numElements the desired number of elements in each fft
     * @return the ffted output
     */
    public static IComplexNDArray fft(INDArray transform, int numElements) {
        return Nd4j.getFFt().fft(transform, numElements);
    }


    /**
     * 1d discrete fourier transform, note that this will
     * throw an exception if the passed in input
     * isn't a vector.
     * See matlab's fft2 for more information
     *
     * @param inputC the input to transform
     * @return the the discrete fourier transform of the passed in input
     */
    public static IComplexNDArray fft(IComplexNDArray inputC) {
        return Nd4j.getFFt().fft(inputC);
    }

    /**
     * 1d discrete fourier transform, note that this will
     * throw an exception if the passed in input
     * isn't a vector.
     * See matlab's fft2 for more information
     *
     * @param input the input to transform
     * @return the the discrete fourier transform of the passed in input
     */
    public static IComplexNDArray fft(INDArray input) {
        return Nd4j.getFFt().fft(input);
    }


    /**
     * FFT along a particular dimension
     *
     * @param transform   the ndarray to transform
     * @param numElements the desired number of elements in each fft
     * @return the ffted output
     */
    public static IComplexNDArray fft(INDArray transform, int numElements, int dimension) {
        return Nd4j.getFFt().fft(transform, numElements, dimension);
    }


    /**
     * 1d discrete fourier transform, note that this will
     * throw an exception if the passed in input
     * isn't a vector.
     * See matlab's fft2 for more information
     *
     * @param inputC the input to transform
     * @return the the discrete fourier transform of the passed in input
     */
    public static IComplexNDArray fft(IComplexNDArray inputC, int numElements) {
        return Nd4j.getFFt().fft(inputC, numElements, inputC.shape().length - 1);
    }


    /**
     * 1d discrete fourier transform, note that this will
     * throw an exception if the passed in input
     * isn't a vector.
     * See matlab's fft2 for more information
     *
     * @param inputC the input to transform
     * @return the the discrete fourier transform of the passed in input
     */
    public static IComplexNDArray fft(IComplexNDArray inputC, int numElements, int dimension) {
        return Nd4j.getFFt().fft(inputC, numElements, dimension);
    }


    /**
     * IFFT along a particular dimension
     *
     * @param transform   the ndarray to transform
     * @param numElements the desired number of elements in each fft
     * @param dimension   the dimension to do fft along
     * @return the iffted output
     */
    public static IComplexNDArray ifft(INDArray transform, int numElements, int dimension) {
        return Nd4j.getFFt().ifft(transform, numElements, dimension);
    }


    /**
     * 1d discrete fourier transform, note that this will
     * throw an exception if the passed in input
     * isn't a vector.
     * See matlab's fft2 for more information
     *
     * @param inputC the input to transform
     * @return the the discrete fourier transform of the passed in input
     */
    public static IComplexNDArray ifft(IComplexNDArray inputC) {
        return Nd4j.getFFt().ifft(inputC);
    }


    /**
     * FFT along a particular dimension
     *
     * @param transform   the ndarray to transform
     * @param numElements the desired number of elements in each fft
     * @return the ffted output
     */
    public static IComplexNDArray ifft(INDArray transform, int numElements) {
        return Nd4j.getFFt().ifft(transform, numElements);
    }


    /**
     * 1d discrete fourier transform, note that this will
     * throw an exception if the passed in input
     * isn't a vector.
     * See matlab's fft2 for more information
     *
     * @param inputC the input to transform
     * @return the the discrete fourier transform of the passed in input
     */
    public static IComplexNDArray ifft(IComplexNDArray inputC, int numElements, int dimension) {
        return Nd4j.getFFt().ifft(inputC, numElements, dimension);
    }

    /**
     * ND IFFT, computes along the first on singleton dimension of
     * transform
     *
     * @param transform   the ndarray to transform
     * @param dimension   the dimension to iterate along
     * @param numElements the desired number of elements in each fft
     * @return the reverse ifft of the passed in array
     */
    public static IComplexNDArray ifftn(INDArray transform, int dimension, int numElements) {
        return Nd4j.getFFt().ifftn(Nd4j.createComplex(transform), dimension, numElements);
    }


    public static IComplexNDArray irfftn(IComplexNDArray arr) {
        return Nd4j.getFFt().irfftn(arr);
    }


    public static IComplexNDArray irfft(IComplexNDArray arr, int dimension) {
        return Nd4j.getFFt().irfft(arr, dimension);
    }

    public static IComplexNDArray irfft(IComplexNDArray arr) {
        return Nd4j.getFFt().irfft(arr);
    }

    /**
     * ND IFFT
     *
     * @param transform   the ndarray to transform
     * @param dimension   the dimension to iterate along
     * @param numElements the desired number of elements in each fft
     * @return the transformed array
     */
    public static IComplexNDArray ifftn(IComplexNDArray transform, int dimension, int numElements) {
        return Nd4j.getFFt().ifftn(transform, dimension, numElements);
    }


    /**
     * Performs FFT along the first non singleton dimension of
     * transform. This means
     *
     * @param transform   the ndarray to transform
     * @param dimension   the dimension to iterate along
     * @param numElements the desired number of elements in each fft
     *                    along each dimension from each slice (note: each slice)
     * @return the transformed array
     */
    public static IComplexNDArray fftn(IComplexNDArray transform, int dimension, int numElements) {
        return Nd4j.getFFt().fftn(transform, dimension, numElements);
    }


    /**
     * Computes the fft along the first non singleton dimension of transform
     * when it is a matrix
     *
     * @param transform   the ndarray to transform
     * @param dimension   the dimension to do fft along
     * @param numElements the desired number of elements in each fft
     * @return the fft of the specified ndarray
     */
    public static IComplexNDArray fftn(INDArray transform, int dimension, int numElements) {
        return Nd4j.getFFt().fftn(Nd4j.createComplex(transform), dimension, numElements);
    }

    /**
     * FFT on the whole array (n is equal the first dimension shape)
     *
     * @param transform the matrix to transform
     * @return the ffted array
     */
    public static IComplexNDArray fftn(INDArray transform) {
        return Nd4j.getFFt().fftn(transform, transform.shape().length - 1, transform.shape()[transform.shape().length - 1]);
    }


    /**
     * FFT on the whole array (n is equal the first dimension shape)
     *
     * @param transform the matrix to transform
     * @return the ffted array
     */
    public static IComplexNDArray fftn(IComplexNDArray transform) {
        return Nd4j.getFFt().fftn(transform, transform.shape().length - 1, transform.shape()[transform.shape().length - 1]);
    }


    public static IComplexNDArray ifftn(IComplexNDArray transform, int dimension) {
        return Nd4j.getFFt().ifftn(transform, dimension, transform.shape()[dimension]);
    }


    public static IComplexNDArray ifftn(IComplexNDArray transform) {
        return Nd4j.getFFt().ifftn(transform);
    }


    public static IComplexNDArray ifftn(INDArray transform) {
        return Nd4j.getFFt().ifftn(transform);
    }

    //underlying ifftn
    public static IComplexNDArray rawifftn(IComplexNDArray transform, int[] shape, int[] axes) {
        return Nd4j.getFFt().rawifftn(transform, shape, axes);
    }

    //underlying fftn
    public static IComplexNDArray rawfftn(IComplexNDArray transform, int[] shape, int[] axes) {
        return Nd4j.getFFt().rawfftn(transform, shape, axes);
    }


    /**
     * Underlying fft algorithm
     *
     * @param transform the ndarray to transform
     * @param n         the desired number of elements
     * @param dimension the dimension to do fft along
     * @return the transformed ndarray
     */
    public static IComplexNDArray rawfft(IComplexNDArray transform, int n, int dimension) {
        return Nd4j.getFFt().rawfft(transform, n, dimension);
    }


    //underlying fftn
    public static IComplexNDArray rawifft(IComplexNDArray transform, int n, int dimension) {
        return Nd4j.getFFt().rawifft(transform, n, dimension);
    }

    //underlying fftn
    public static IComplexNDArray rawifft(IComplexNDArray transform, int dimension) {
        return Nd4j.getFFt().rawifft(transform, transform.shape()[dimension], dimension);
    }

}