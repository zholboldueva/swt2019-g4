package com.machich.jpa.example.repository;

        import com.machich.jpa.example.model.Auftrag;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

@Repository(value="auftragRepository")
public interface AuftragRepository extends JpaRepository<Auftrag, Integer> {

   Auftrag findById(int id);
}