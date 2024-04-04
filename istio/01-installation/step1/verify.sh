#!/bin/bash

#!/bin/bash

binary_name="istioctl"

if command -v "$binary_name" &> /dev/null;
then
    echo "$binary_name is installed.";
    exit 0;
else
    echo "$binary_name is not installed.";
    exit 1;
fi
