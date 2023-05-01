package ${basePackage}.${modelName}.controller;

import ${basePackage}.${modelName}.dto.${modelNameUpperCamel}Dto;
import com.shimi.gsf.common.model.BaseFilter;
import ${basePackage}.${modelName}.model.${modelNameUpperCamel};
import ${basePackage}.${modelName}.service.${modelNameUpperCamel}Service;
import ${basePackage}.common.controller.BaseController;
import com.shimi.gsf.common.dto.Dto;
import com.shimi.gsf.common.dto.DtoQueryResult;
import com.shimi.gsf.common.model.EntityQueryResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/${modelNameLowerCamel}s")
@Tag(name = "${modelNameLowerCamel}", description = "${modelNameUpperCamel} Management API")
public class ${modelNameUpperCamel}Controller extends BaseController {

    private final ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    public ${modelNameUpperCamel}Controller(${modelNameUpperCamel}Service ${modelNameLowerCamel}Service) {
        this.${modelNameLowerCamel}Service = ${modelNameLowerCamel}Service;
    }

    @Operation(summary = "Create new ${modelNameLowerCamel}")
    @Parameter(name = "${modelNameLowerCamel}", description = "The ${modelNameLowerCamel} data")
    @PostMapping
    public ${modelNameUpperCamel}Dto create(@RequestBody ${modelNameUpperCamel}Dto ${modelNameLowerCamel}Dto) {
        ${modelNameUpperCamel} saved${modelNameUpperCamel} = ${modelNameLowerCamel}Service.create(${modelNameLowerCamel}Dto.toEntity());
        return saved${modelNameUpperCamel}.toDto(true);
    }



    @Operation(summary = "Update ${modelNameLowerCamel} by ID")
    @Parameter(name = "id", description = "The ${modelNameLowerCamel} id")
    @Parameter(name = "${modelNameLowerCamel}", description = "The ${modelNameLowerCamel} dto")
    @PutMapping("{id}")
    public ${modelNameUpperCamel}Dto update(@PathVariable Long id, @RequestBody ${modelNameUpperCamel}Dto ${modelNameLowerCamel}Dto) {
        ${modelNameUpperCamel} saved${modelNameUpperCamel} = ${modelNameLowerCamel}Service.update(id, ${modelNameLowerCamel}Dto.toEntity());
        return saved${modelNameUpperCamel}.toDto(true);
    }

    @Operation(summary = "Get existed ${modelNameLowerCamel} by ID")
    @Parameter(name = "id", description = "The ${modelNameLowerCamel} id")
    @GetMapping("/{id}")
    public ${modelNameUpperCamel}Dto get(@PathVariable Long id) {
        ${modelNameUpperCamel} existed${modelNameUpperCamel}=  ${modelNameLowerCamel}Service.get(id);
        return existed${modelNameUpperCamel}.toDto(true);
    }

    @Operation(summary = "Delete existed ${modelNameLowerCamel} by ID")
    @Parameter(name = "id", description = "The ${modelNameLowerCamel} id")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ${modelNameLowerCamel}Service.delete(id);
    }

    @Operation(description = "This api is only prepared for admin", summary = "Search products by query filter")
    @Parameter(name = "filter", description = "The query filter")
    @GetMapping
    public DtoQueryResult<Dto> findAll(BaseFilter filter) {
        EntityQueryResult<${modelNameUpperCamel}> queryResult =  ${modelNameLowerCamel}Service.search(filter);
        return queryResult.toDto();
    }

    @Operation(summary = "Search products by query filter")
    @Parameter(name = "filter", description = "The query filter")
    @GetMapping("/search")
    public DtoQueryResult<Dto> search(@RequestBody BaseFilter filter) {
        EntityQueryResult<${modelNameUpperCamel}> queryResult =  ${modelNameLowerCamel}Service.search(filter);
        return queryResult.toDto();
    }
}
