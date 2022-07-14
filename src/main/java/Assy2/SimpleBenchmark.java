package Assy2;

import org.openjdk.jmh.annotations.*;


import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class SimpleBenchmark {

    @Benchmark
    @Fork(value = 2)
    @Measurement(iterations = 3, time = 1)
    @Warmup(iterations = 2, time = 1)
    public int sumArrayStream(SumParams params){
        return Arrays.stream(params.elements).sum();
    }

    @Benchmark
    @Fork(value = 2)
    @Measurement(iterations = 3, time = 1)
    @Warmup(iterations = 2, time = 1)
    public int forEachSum(SumParams params){
        int result = 0;

        for(int element : params.elements){
            result += element;
        }
        return result;
    }

    @State(Scope.Benchmark)
    public static class SumParams{

        @Param({"300", "900", "2700", "8100", "24300"})
        public int n;

        public int[] elements;

        @Setup
        public void setUp(){
            elements = IntStream.range(0,n).toArray();
        }
    }
}
