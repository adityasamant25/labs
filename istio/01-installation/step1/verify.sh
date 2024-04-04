#!/usr/bin/env bash

output=$(istioctl version)

if [[ $output == 1* ]]; then
  echo "istioctl is installed"
  exit 0
else
  echo "istioctl is not installed"
  exit 1
fi