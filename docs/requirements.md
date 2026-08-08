# Treasureverse Requirements

## Overview

Treasureverse is a social showcase platform for sharing personal treasures through photos, posts, profiles, and community interactions.

The product is intentionally not a C2C marketplace. Commerce features are out of scope.

## Out Of Scope

- Fixed-price sales
- Auctions
- Bidding
- Orders
- Payments
- Shipping
- Escrow
- Seller dashboards
- Buyer checkout flows
- Product inventory management

## Core Features

### Member And Auth

- Users can create an account with email and password.
- Users can later sign in with OAuth providers such as Google, Kakao, or Naver.
- A member may have zero or more connected social accounts.
- Password-based accounts and OAuth accounts must map to the same member model.
- Members have roles and status values for future authorization and account control.

### Profile

- Users can manage a public profile.
- Profiles include nickname, bio, profile image, and optional links.
- A profile page shows the user's posts.

### Post

- Users can create posts with photos and text.
- Users can view a feed of recent posts.
- Users can view a single post with comments.
- Users can edit or delete their own posts.

### Comment

- Users can comment on posts.
- Users can edit or delete their own comments.
- Reply support can be added after basic comments are stable.

### Like

- Users can like and unlike posts.
- Post responses can include like count.

### Follow

- Users can follow and unfollow other users.
- Follow data can later drive a personalized feed.

### Storage

- Images are uploaded through a storage abstraction.
- Local development uses MinIO as S3-compatible object storage.
- The application stores image metadata and object URLs, not raw image bytes, in MySQL.
- Post and profile domains must not depend directly on the MinIO SDK.
- Cloud storage such as AWS S3 can be added later without changing post APIs.

## Suggested Domain Model

### members

- id
- email
- password nullable
- nickname
- role
- status
- created_at
- updated_at
- deleted_at nullable

### social_accounts

- id
- member_id
- provider
- provider_user_id
- email
- created_at

### profiles

- id
- member_id
- bio
- profile_image_url
- created_at
- updated_at

### posts

- id
- member_id
- content
- created_at
- updated_at
- deleted_at nullable

### post_images

- id
- post_id
- image_url
- object_key
- sort_order
- created_at

### stored_files

- id
- original_filename
- content_type
- size
- bucket
- object_key
- public_url
- created_at

### comments

- id
- post_id
- member_id
- parent_id nullable
- content
- created_at
- updated_at
- deleted_at nullable

### post_likes

- id
- post_id
- member_id
- created_at

### follows

- id
- follower_id
- following_id
- created_at

## Initial Issue Roadmap

1. Initialize Spring Boot project.
2. Define member and social account domain model.
3. Implement email signup.
4. Implement login foundation.
5. Add Spring Security configuration.
6. Implement profile domain.
7. Implement post creation and retrieval.
8. Implement MinIO-backed image upload abstraction.
9. Implement comments.
10. Implement likes.
11. Implement follows.

## Issue Quality Bar

Each implementation issue should include:

- Problem statement
- Scope
- Out-of-scope items
- Acceptance criteria
- Expected API shape when relevant
- Test expectations
