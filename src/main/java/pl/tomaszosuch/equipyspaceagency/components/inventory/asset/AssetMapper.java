package pl.tomaszosuch.equipyspaceagency.components.inventory.asset;

import org.springframework.stereotype.Service;
import pl.tomaszosuch.equipyspaceagency.components.inventory.category.Category;
import pl.tomaszosuch.equipyspaceagency.components.inventory.category.CategoryRepository;

import java.util.Optional;

@Service
public class AssetMapper {

    private CategoryRepository categoryRepository;

    public AssetMapper(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    AssetDto toDto(Asset asset){
        AssetDto dto = new AssetDto();
        dto.setId(asset.getId());
        dto.setName(asset.getName());
        dto.setDescription(asset.getDescription());
        dto.setPrice(asset.getPrice());
        dto.setSerialNumber(asset.getSerialNumber());
        if (asset.getCategory() != null){
            dto.setCategory(asset.getCategory().getName());
        }
        return dto;
    }

    Asset toEntity(AssetDto asset){
        Asset entity = new Asset();
        entity.setId(asset.getId());
        entity.setName(asset.getName());
        entity.setDescription(asset.getDescription());
        entity.setPrice(asset.getPrice());
        Optional<Category> category = categoryRepository.findByName(asset.getCategory());
        category.ifPresent(entity::setCategory);
        entity.setSerialNumber(asset.getSerialNumber());
        return entity;
    }
}
