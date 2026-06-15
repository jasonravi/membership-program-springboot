#!/bin/bash

set -e

BASE_URL="http://localhost:8080/api/v1/memberships"

echo "========================================="
echo "Membership Program E2E Test Started"
echo "========================================="

USER_ID="USER_1001"

echo ""
echo "1. Get Membership Plans"
echo "-----------------------------------------"

curl --silent \
--request GET \
"${BASE_URL}/plans" | jq .

echo ""
echo "2. Subscribe User"
echo "-----------------------------------------"

curl --silent \
--request POST \
"${BASE_URL}/subscribe" \
--header "Content-Type: application/json" \
--data '{
  "userId":"USER_1001",
  "planType":"YEARLY",
  "metrics":{
      "monthlyOrderCount":30,
      "monthlyOrderValue":30000,
      "cohort":"VIP"
  }
}' | jq .

echo ""
echo "3. Get Current Membership"
echo "-----------------------------------------"

curl --silent \
--request GET \
"${BASE_URL}/${USER_ID}" | jq .

echo ""
echo "4. Upgrade Membership"
echo "-----------------------------------------"

curl --silent \
--request POST \
"${BASE_URL}/${USER_ID}/upgrade" | jq .

echo ""
echo "5. Verify Membership After Upgrade"
echo "-----------------------------------------"

curl --silent \
--request GET \
"${BASE_URL}/${USER_ID}" | jq .

echo ""
echo "6. Downgrade Membership"
echo "-----------------------------------------"

curl --silent \
--request POST \
"${BASE_URL}/${USER_ID}/downgrade" | jq .

echo ""
echo "7. Verify Membership After Downgrade"
echo "-----------------------------------------"

curl --silent \
--request GET \
"${BASE_URL}/${USER_ID}" | jq .

echo ""
echo "8. Cancel Membership"
echo "-----------------------------------------"

curl --silent \
--request DELETE \
"${BASE_URL}/${USER_ID}"

echo ""
echo ""
echo "9. Verify Membership Removed"
echo "-----------------------------------------"

HTTP_CODE=$(curl \
--silent \
--output response.json \
--write-out "%{http_code}" \
--request GET \
"${BASE_URL}/${USER_ID}")

echo "HTTP Status: ${HTTP_CODE}"

cat response.json

echo ""
echo ""
echo "========================================="
echo "Membership Program E2E Test Completed"
echo "========================================="