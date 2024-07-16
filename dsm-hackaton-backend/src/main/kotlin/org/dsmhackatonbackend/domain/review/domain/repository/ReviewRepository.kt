package org.dsmhackatonbackend.domain.review.domain.repository

import org.dsmhackatonbackend.domain.review.domain.Review
import org.springframework.data.repository.CrudRepository

interface ReviewRepository : CrudRepository<Review, Long> {
}
