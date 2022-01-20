<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class mealtype extends Model
{
    use HasFactory;
    protected $table = 'mealtypes';
    protected $fillable = ['codMealType', 'name'];
}
