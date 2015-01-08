#include <stdio.h>
#include <set>

inline bool isChar(int &c) {
    return c > 47 && c < 58;
}

void scan(int &value) {
    register int c = getchar_unlocked();
    value = 0;
    int negate = 0;
    for(; ((c < 48 || c > 57) && (c != 45)); c = getchar_unlocked());
    if (c == '-')
        negate = 1,
        c = getchar_unlocked();
    for(; isChar(c); c = getchar_unlocked())
        value = (value << 1) + (value << 3) + c - 48;
    if (negate)
        value = -value;
}

void scanAbsolute(int &value) {
    register int c = getchar_unlocked();
    int x = 0;
    for(; ((c < 48 || c > 57)); c = getchar_unlocked());
    for(; isChar(c); c = getchar_unlocked())
        x = (x << 1) + (x << 3) + c - 48;
    value = x;
}

unsigned long getMaximumCount(std::multiset<int> *set) {
    unsigned long maxValueCount = 0;
    for (std::multiset<int>::iterator i = set->begin(); i != set->end(); i++) {
        unsigned long valueCount = set->count(*i);
        if (maxValueCount < valueCount)
            maxValueCount = valueCount;
    }
    return maxValueCount;
}

int main() {
    int matrixSize, numberOfRectangles;
    scanAbsolute(matrixSize);
    scanAbsolute(numberOfRectangles);
    int matrix[matrixSize][matrixSize];
    for (int y = 0; y < matrixSize; y++)
        for (int x = 0; x < matrixSize; x++)
            scan(matrix[x][y]);
    int overallValue = 0;
    std::multiset<int> multiset;
    for (int i = 0; i < numberOfRectangles; i++) {
        int ax, ay, bx, by;
        scanAbsolute(ay),
        scanAbsolute(ax),
        scanAbsolute(by),
        scanAbsolute(bx);
        int sum = 0;
        for (int x = ax; x <= bx; x++)
            for (int y = ay; y <= by; y++)
                sum += matrix[x][y];
        overallValue += sum;
        multiset.insert(sum);
    }
    overallValue /= numberOfRectangles;
    unsigned long max = getMaximumCount(&multiset);
    std::set<int> output;
    for (std::multiset<int>::iterator i = multiset.begin(); i != multiset.end(); i++) {
        int val = *i;
        if (multiset.count(val) == max)
            output.insert(val);
    }
    for (std::multiset<int>::iterator i = multiset.begin(); i != multiset.end() || multiset.count(*i) > 1; i++)
        multiset.erase(*i), multiset.insert(*i);
    printf("%lu %lu %d", multiset.size(), output.size(), overallValue);
    return 0;
}
