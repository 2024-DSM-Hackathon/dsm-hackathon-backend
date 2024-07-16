package org.dsmhackathonbackend.domain.review.domain.repository

import org.dsmhackathonbackend.domain.review.domain.Review
import org.springframework.data.repository.CrudRepository

interface ReviewRepository : CrudRepository<Review, Long> {
}
