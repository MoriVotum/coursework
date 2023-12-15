#!/bin/bash
rm -rf constant/polyMesh
blockMesh
pimpleFoam
paraFoam
