package com.eliarojr.spring_data_jpa.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name = "guardian_name")
        ),
        @AttributeOverride(
                name = "emailAddress",
                column = @Column(name = "guardian_email")
        ),
        @AttributeOverride(
                name = "mobileNumber",
                column = @Column(name = "guardian_mobile")
        )
})
public class Guardian {

    private String name;
    private String emailAddress;
    private  String mobileNumber;
}
