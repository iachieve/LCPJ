class Solution {
    public boolean isPowerOfFour(int n) {
//         int alternatingOddBitMask = 0x55555555; // 1010101010101010101010101010101
//         boolean isNonZero = (n != 0);
//         boolean hasSingleLeadingOneBit = (n & (n - 1)) == 0;
//         boolean hasOnlyOddPositionedBits = (n & alternatingOddBitMask) == n;

//         return isNonZero && hasSingleLeadingOneBit && hasOnlyOddPositionedBits;
        
                return (Math.log10(n) / Math.log10(4)) % 1 == 0;

    }
}

/*



```

```


```
    public boolean isPowerOfFour(int n) {
       return (Math.log(n) / Math.log(4)) % 1 == 0;
    }
```

```
    public boolean isPowerOfFour(int n) {
        if(n == 0) return false;
        while(n != 1){
            if(n % 4 != 0) return false;
            n /= 4;
        }
        return true;
    }
}
```

```
   public boolean isPowerOfFour(int n) {
        return ((n & (n-1)) == 0 && (n % 3) == 1);
    }
``` 
*/
