#!/usr/bin/env bash

binary_name="istioctl"

if which "$binary_name" 2> /dev/null ; then
  echo "istioctl is installed"
  exit 0
else
  echo "istioctl is not installed"
  exit 1
fi