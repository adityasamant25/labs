#!/bin/bash

binary_name="istioctl"

if which "$binary_name" 2> /dev/null;
then
    echo "$binary_name is installed.";
else
    echo "$binary_name is not installed.";
    exit 1;
fi
