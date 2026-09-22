#!/bin/bash

echo "=== building project ==="
mvn clean package -dskiptests

if [ $? -ne 0 ]; then
    echo "build failed"
    exit 1
fi

echo "=== copying war to server ==="
scp target/vels-onboarding-platform-1.0.0.jar user@server:/opt/vels/

echo "=== restarting application ==="
ssh user@server "systemctl restart vels-onboarding"

echo "=== deployment complete ==="