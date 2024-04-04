#!/bin/bash

#!/bin/bash

binary_name="istioctl"

if command -v "$binary_name" &> /dev/null
then
    echo "$binary_name is installed."
else
    echo "$binary_name is not installed."
fi
