package pl.tomaszosuch.equipyspaceagency.components.user;

import pl.tomaszosuch.equipyspaceagency.components.assignment.Assignment;
import pl.tomaszosuch.equipyspaceagency.components.inventory.asset.Asset;

public class UserAssignmentMapper {

    static UserAssignmentDto toDto(Assignment assignment) {
        UserAssignmentDto dto = new UserAssignmentDto();
        dto.setId(assignment.getId());
        dto.setAssetId(assignment.getId());
        dto.setStart(assignment.getStart());
        dto.setEnd(assignment.getEnd());
        Asset asset = assignment.getAsset();
        dto.setAssetName(asset.getName());
        dto.setAssetSerialNumber(asset.getSerialNumber());
        return dto;
    }
}
