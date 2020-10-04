package ir.safari.show.entity.dto;

import lombok.Getter;

@Getter
public class PerformanceResponse {
    private Double averageScore;
    private String songName;
    private Long candidateId;

     public PerformanceResponse(Double averageScore, String songName, Long candidateId) {
          this.averageScore = averageScore;
          this.songName = songName;
          this.candidateId = candidateId;
     }
}
