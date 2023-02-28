package org.http4k.connect.kafka.rest.partitioning

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.http4k.connect.kafka.rest.model.PartitionId
import org.junit.jupiter.api.Test

class RoundRobinPartitionerKtTest {
    @Test
    fun `round robins the partitions`() {
        val p = RoundRobinRecordPartitioner<String, String>(
            listOf(
                PartitionId.of(1),
                PartitionId.of(2),
                PartitionId.of(3),
            )
        )

        assertThat(p("hello", "world"), equalTo(PartitionId.of(1)))
        assertThat(p("hello", "world"), equalTo(PartitionId.of(2)))
        assertThat(p("hello", "world"), equalTo(PartitionId.of(3)))
        assertThat(p("hello", "world"), equalTo(PartitionId.of(1)))
        assertThat(p("hello", "world"), equalTo(PartitionId.of(2)))
        assertThat(p("hello", "world"), equalTo(PartitionId.of(3)))
    }

}

